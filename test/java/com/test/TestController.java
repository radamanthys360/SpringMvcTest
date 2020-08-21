package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springdemo.controller.TaringueroController;
import com.springdemo.db.entity.Genero;
import com.springdemo.db.entity.Version;
import com.springdemo.dto.TaringueroDto;
import com.springdemo.services.GeneroServices;
import com.springdemo.services.UsuarioServices;
import com.springdemo.services.VersionServices;

@ExtendWith(MockitoExtension.class)
class TestController {

   @Autowired
   private MockMvc mockMvc;

   @InjectMocks
   private TaringueroController taringueroController;
   
   
   @Mock
   private GeneroServices generoServices;
     
   @Mock
   private VersionServices versionServices;

   @Mock
   private UsuarioServices usuarioServices;
   

   
   @BeforeEach
   public void init() {
       mockMvc = MockMvcBuilders.standaloneSetup(this.taringueroController).build();
   }
    
	//@Disabled("Ya esta testeado")
    @Test
    public void prueba() throws Exception {
    	llenarServicio();
    	
             mockMvc
            .perform(post("/taringuero/prueba"))
            .andDo(print())
            .andExpect(view().name("hola"))
            .andExpect(status().isOk())
            .andReturn();
    }
    
	//@Disabled("Ya esta testeado")
    @Test
    public void mostrarForm() throws Exception {
    	llenarServicio();
    	
             mockMvc
            .perform(post("/taringuero/mostrarform"))
            .andDo(print())
            .andExpect(view().name("taringuero-form"))
            .andExpect(status().isOk())
            .andReturn();
    }
	
	//@Disabled("Ya esta testeado")
    @Test
    public void mostrarformP() throws Exception {
    	llenarServicio();
    	//propio del metodo
    	List<Integer> listaPaginador = new ArrayList<Integer>();
    	Pageable pageable = PageRequest.of(0, 5);

    	listaPaginador = new ArrayList<Integer>();
    	listaPaginador.add(1);
    	List<TaringueroDto> usuarioDTO2 = Arrays.asList(
                new TaringueroDto((long) 01,"test11","MASCULINO","S","S","V5,V6",29,listaPaginador),
                new TaringueroDto((long) 02,"test111","MASCULINO","S","S","V5,V6",29,listaPaginador)
        );
    	pageable = PageRequest.of(0, 5);
    	Mockito.when(usuarioServices.busquedaTotal("111",pageable)).thenReturn(usuarioDTO2);
       //probando la busqueda por texto y paginada
             mockMvc
            .perform(get("/taringuero/mostrarformP")
                     .param("pagg", "1")
                     .param("tipo", "2")  
                     .param("bus", "111"))
            .andDo(print())
            .andExpect(view().name("taringuero-form"))
            .andExpect(status().isOk())
            .andReturn();
    }
	
	//@Disabled("Ya esta testeado")
    @Test
    public void procesarForm() throws Exception {
    	llenarServicio();
    	TaringueroDto taringueroDto = new TaringueroDto(null,"testnew","MASCULINO","S","S","",34,null);
    	Genero genero = new Genero("MASCULINO");
    	Optional<Genero> optional = Optional.of(genero);
    	Mockito.when(generoServices.getGenero("MASCULINO")).thenReturn(optional);
    	
             mockMvc
            .perform(post("/taringuero/procesarform")
            		.flashAttr("taringueroDto", taringueroDto))
            .andDo(print())
            .andExpect(view().name("redirect:" + "/taringuero/modificar"))
            .andExpect(model().hasNoErrors())
            .andExpect(status().is3xxRedirection())
            .andReturn();
    }
    
	//@Disabled("Ya esta testeado")
    @Test
    public void procesarFormError() throws Exception {
    	llenarServicio();
    	TaringueroDto taringueroDto = new TaringueroDto();
             mockMvc
            .perform(post("/taringuero/procesarform")
            		.flashAttr("taringueroDto", taringueroDto))
            .andDo(print())
            .andExpect(view().name("taringuero-form"))
            .andExpect(status().isOk())
            .andExpect(model().attributeHasErrors("taringueroDto"))
            .andExpect(model().attributeHasFieldErrors("taringueroDto", "nombreUsuario"))
            .andExpect(model().attributeHasFieldErrors("taringueroDto", "sigoVirgo"))
            .andExpect(model().attributeHasFieldErrors("taringueroDto", "genero"))
            .andReturn();
    }
	
	
    //se llenan algunos datos del modelo obligatorios
    private void llenarServicio() {
    	List<Genero> todosGeneros = Arrays.asList(
                new Genero("Masculino"),
                new Genero("Femenino")
        );
    	
    	Mockito.when(generoServices.getAllGenero()).thenReturn(todosGeneros);
    	List<Version> tododsVersion = Arrays.asList(
                new Version("V7","la v7"),
                new Version("V8","la v8")
        );
    	Mockito.when(versionServices.getAllVersion()).thenReturn(tododsVersion);
    }
    

}
