package com.example.nikki;

import com.example.nikki.form.DeleteForm;
import com.example.nikki.form.Form;
import com.example.nikki.model.diary.Entity;
import com.example.nikki.model.diary.service;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/diary")
@AllArgsConstructor
public class diaryController {
private final service se;
    @GetMapping
    public String showTop(Model model, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache");
        List<Entity> entityList=se.entityFindByLimit();
        model.addAttribute("entitylist",entityList);
      return"top";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("entity",new Entity());



        return"diarys/create-diary";
    };
    @PostMapping("/create")
    public String postCreate(@Validated  @ModelAttribute Entity entity, BindingResult br, RedirectAttributes redirectAttributes){
   if(br.hasErrors()){
       redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.entity", br);
       redirectAttributes.addFlashAttribute("entity", entity);

       return"diarys/create-diary";

   }
   se.EntityService(entity);
        return "redirect:/diary/list";
    }
    @GetMapping("/list")
    public String Showlist(Model model){

        List<Entity> entityList=se.entityFindAll();
        model.addAttribute("entitylist",entityList);
        return "diarys/list";
    }

    @PostMapping("/delete/{id}")
    public String Showdelete(@PathVariable("id") Integer id){
        se.delete(id);

        return "redirect:/diary/list";
    }

    @PostMapping("/delete/top/{id}")
    public String ShowdeleteTop(@PathVariable("id") Integer id){
        se.delete(id);

        return "redirect:/diary";
    }
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") Integer id,Model model){
       Entity entity = se.findId(id);
       model.addAttribute("entity", entity);
        return"diarys/updateform";
    };
    @PostMapping("/update")
    public String Update(@RequestParam("id")Integer id,@ModelAttribute Entity entity){
        System.out.println("Before Update: " + entity);
        System.out.println("Before Update - Entity ID: " + entity.getId());
        System.out.println("Before Update - Entity Date: " + entity.getDate());

        System.out.println("After Update: " + entity);
        se.Update(entity);
        return "redirect:/diary";
    }
    @GetMapping("/{id}")
    public String detail(@PathVariable("id")Integer id,Model model){
        Entity entity = se.findId(id);
        model.addAttribute("entitylist",entity);
        return "/detail";
    }



}

