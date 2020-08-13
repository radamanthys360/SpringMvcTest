package com.springdemo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdemo.db.entity.Genero;
import com.springdemo.db.entity.Usuario;
import com.springdemo.db.entity.Version;
import com.springdemo.dto.TaringueroDto;
import com.springdemo.services.GeneroServices;
import com.springdemo.services.UsuarioServices;
import com.springdemo.services.VersionServices;

@Controller
@RequestMapping("/taringuero")
public class TaringueroController {
	
	private Integer SET_DATOS = 5;
	
	@Autowired
	GeneroServices generoServices;
	
	@Autowired
	VersionServices versionServices;
	
	@Autowired
	UsuarioServices usuarioServices;
	
	//metodo para quitar espacios en blanco
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@ModelAttribute("getgenero")
	public LinkedHashMap<String, String> getGenero()
	{
		
		//para llenar combo de genero
		LinkedHashMap<String, String> generoOptions = new LinkedHashMap<>();
		generoOptions.put("", "Selecciona uno");
		for (Genero genero : generoServices.getAllGenero()) {
		generoOptions.put(genero.getTipo(),
				StringUtils.capitalize(genero.getTipo().toLowerCase()));
		}
		return generoOptions;
	}
	
	@ModelAttribute("getversiones")
	public List<String> getVersiones()
	{
		//versiones de taringa existentes
		List<String> versionesData = new ArrayList<String>();
		for (Version version : versionServices.getAllVersion()) {
			versionesData.add(version.getCodigo());
		}
		return versionesData;
	}
	
	@RequestMapping("/mostrarform")
	public String mostrarform(Model modelo) {
		TaringueroDto taringueroDtoF = new TaringueroDto();
		modelo.addAttribute("taringueroDto",taringueroDtoF);
		//llenando tabla por defecto el primer set 
		Pageable pageable = PageRequest.of(0, SET_DATOS);
		modelo.addAttribute("tabladata",usuarioServices.retornarSetUsuarios(pageable));
		//ajustando elementos del paginador
		List<Integer> datosPaginador = datosPaginador();
		modelo.addAttribute("paginador",datosPaginador);
		String resultado = (datosPaginador.isEmpty())? "  No se han Encontrado Registros":"";
		modelo.addAttribute("mensajeP","Pagina 1 de "+datosPaginador.size()+resultado);
		return "taringuero-form";
	}
	
	@RequestMapping(value = "/mostrarformP",method = RequestMethod.GET)
	public String mostrarformPag(Model modelo,@RequestParam("pagg")Integer pag) {
		TaringueroDto taringueroDtoF = new TaringueroDto();
		modelo.addAttribute("taringueroDto",taringueroDtoF);
		//test
		//llenando tabla por defecto el primer set de 5 registros
		Pageable pageable = PageRequest.of((pag -1), SET_DATOS);
		modelo.addAttribute("tabladata",usuarioServices.retornarSetUsuarios(pageable));
		//ajustando elementos del paginador
		List<Integer> datosPaginador = datosPaginador();
		modelo.addAttribute("paginador",datosPaginador);
		modelo.addAttribute("mensajeP","Pagina "+(pag)+" de "+datosPaginador.size());
		return "taringuero-form";
	}
	
	
	private List<Integer> datosPaginador() {
		Integer count = Math.toIntExact(usuarioServices.getCount());
		List<Integer> ListaPaginador = new ArrayList<Integer>();
		if(count % SET_DATOS == 0) {
			double decimal = count/SET_DATOS;
			for (int i = 1; i <= (int)Math.round(decimal); i++) {
				ListaPaginador.add(i);
			}
		}else {
			 double decimal = count/SET_DATOS;
			 Integer paginador = (int)Math.round(decimal);
				for (int i = 1; i <= (paginador + 1); i++) {
					ListaPaginador.add(i);
			}
		}
		 return ListaPaginador;
	}
	
	@RequestMapping("/procesarform")
	public String procesarform(@Valid @ModelAttribute("taringueroDto") TaringueroDto taringueroDto,
			                   BindingResult theBindingResult) {
		//System.err.println(theBindingResult);
		if (theBindingResult.hasErrors()) {
			return "taringuero-form";
		}
		else {
			try {
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(taringueroDto.getNombreUsuario());
			    usuario.setEdad(taringueroDto.getEdad());
			    Optional<Genero> genero2 = generoServices.getGenero(taringueroDto.getGenero());
			    if (genero2.isPresent()){
			    	usuario.setGenero(genero2.get());
			    }
			    else{
			    	throw new Exception();
			    }
			    usuario.setSigoVirgo(taringueroDto.getSigoVirgo());
			    usuario.setFacha(taringueroDto.getFacha());

			    Set<Version> listaUsuVer = new  HashSet<Version>();
				for (String var : taringueroDto.getVersiones()) {
					Optional<Version> version = versionServices.getVersion(var);
				    if (version.isPresent()){
					    listaUsuVer.add(version.get());
				    }
				    else{
				    	throw new Exception();
				    }
				}
				usuario.setVersiones(listaUsuVer);
				usuarioServices.guardar(usuario);
				//throw new Exception();
				return "redirect:/taringuero/modificar";
			}catch(Exception ex){
				return "redirect:/taringuero/error";
			}
		}
	}
	
	@RequestMapping("/modificar")
	public String modificar(Model modelo) {
		TaringueroDto taringueroDto = new TaringueroDto();
		modelo.addAttribute("taringueroDto",taringueroDto);
		modelo.addAttribute("guardar","S");
		modelo.addAttribute("mensaje","Guardado Correctamente");
		//llenando tabla por defecto el primer set 
		Pageable pageable = PageRequest.of(0, SET_DATOS);
		modelo.addAttribute("tabladata",usuarioServices.retornarSetUsuarios(pageable));
		//ajustando elementos del paginador
		List<Integer> datosPaginador = datosPaginador();
		modelo.addAttribute("paginador",datosPaginador);
		modelo.addAttribute("mensajeP","Pagina 1 de "+datosPaginador.size());
		return "taringuero-form";
	}
	
	@RequestMapping("/error")
	public String error(Model modelo) {
		TaringueroDto taringueroDto = new TaringueroDto();
		modelo.addAttribute("taringueroDto",taringueroDto);
		modelo.addAttribute("error","S");
		modelo.addAttribute("mensaje","Ha ocurrido un error al tratar de ejecutar la operacion");
		//llenando tabla por defecto el primer set 
		Pageable pageable = PageRequest.of(0, SET_DATOS);
		modelo.addAttribute("tabladata",usuarioServices.retornarSetUsuarios(pageable));
		//ajustando elementos del paginador
		List<Integer> datosPaginador = datosPaginador();
		modelo.addAttribute("paginador",datosPaginador);
		modelo.addAttribute("mensajeP","Pagina 1 de "+datosPaginador.size());
		return "taringuero-form";
	}
	
	
}
