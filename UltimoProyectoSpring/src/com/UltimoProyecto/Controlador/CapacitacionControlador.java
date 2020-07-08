package com.UltimoProyecto.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.UltimoProyecto.beans.Capacitacion;
import com.UltimoProyecto.dao.CapacitacionDao;   

@Controller
public class CapacitacionControlador {

	@Autowired
	CapacitacionDao dao;
	
    @RequestMapping("/cliform")    
    public String showform(Model m){    
        m.addAttribute("command", new Capacitacion());  
        return "cliform";
    } 

    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("cli") Capacitacion cli){    
        dao.save(cli);
        return "redirect:/viewcli";
    }
    
    @RequestMapping("/viewcli")    
    public String viewcli(Model m){    
        List<Capacitacion> list=dao.getCapacitacion();
        m.addAttribute("list",list);  
        return "viewcli";
    }
    /*
    @RequestMapping(value="/editcli/{id}")    
    public String edit(@PathVariable int id, Model m){    
    	Capacitacion cli=dao.getCliById(id);
        m.addAttribute("command",cli);
        return "clieditform";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("cli") Capacitacion cli){
        dao.update(cli);
        return "redirect:/viewcli";
    }

    @RequestMapping(value="/deletecli/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewcli";
    }
 */   
}

