package com.itec.clinic.controller;

import com.itec.clinic.entity.Page;
import com.itec.clinic.entity.Person;
import com.itec.clinic.service.LoginService;
import com.itec.clinic.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainController{

//    @Autowired
//    private TestService testService;//扫描service包中的注释 自动装配

    @Autowired
    private PersonService personService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index(){
        return"index";
    }

//    @RequestMapping(value = "/listPerson")
//    public String listPerson(Model model, Page page){
//        List<Person> list = personService.findAll();
////        List<Person> list = personService.findPersonByPage(page);
//        model.addAttribute("list",list);
//        return "listPersonPage";
//    }

    //进入添加页面
    @RequestMapping(value = "/addPerson")
    public String addPerson(){
        return "addPersonPage";
    }

    //将添加的对象加入数据库
    @RequestMapping(value = "/savePerson",method = RequestMethod.GET)
    public String savePerson(@Validated Person person,Model model,BindingResult bindingResult)throws Exception{//建立一个对象，属性名对应请求参数名保持一致，并由getter()和setter()方法 可以从前台获取到参数
//        if(bindingResult.hasErrors()){
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError objectError :allErrors){
//                //properties文件默认无法输入中文，所以改成了utf-8编码
//                //但是这样读取出来是乱码，所以要转换成iso，再生成utf8
//                System.out.println(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"),"UTF8"));
//            }
//            model.addAttribute("allErrors",allErrors);
//            return "addPersonPage";
//        }
        personService.addPerson(person);
        //System.out.println("person="+person.getId());
        return "redirect:/listPersonByPage"; //重定向返回String 不然会以为跳转到jsp
    }

    @RequestMapping(value = "/toEditPerson")
    public String toEditPerson(Model model,@RequestParam(value = "id",defaultValue="0") String id){
        Person person = personService.findById(id);
        model.addAttribute("person",person);
        return "editPersonPage";
    }

    @RequestMapping(value = "/editPerson")
    public String editPerson(@Validated  Person person,Model model,BindingResult bindingResult)throws Exception{
//        if(bindingResult.hasErrors()){
//            List<ObjectError> allErrors = bindingResult.getAllErrors();
//            for (ObjectError objectError :allErrors){
//                //properties文件默认无法输入中文，所以改成了utf-8编码
//                //但是这样读取出来是乱码，所以要转换成iso，再生成utf8
//                System.out.println(new String(objectError.getDefaultMessage().getBytes("ISO-8859-1"),"UTF8"));
//            }
//            model.addAttribute("allErrors",allErrors);
//            return "editPersonPage";
//        }
        personService.editPerson(person);
        return "redirect:/listPersonByPage";
    }

    @RequestMapping(value = "/deletePerson")
    public String deletePerson(@RequestParam(value = "id",defaultValue = "0") String id){
        personService.deletePerson(id);
        return "redirect:/listPersonByPage";
    }

    @RequestMapping(value = "/searchByPersonName")
    public String searchByPersonName(Model model,@RequestParam(value = "search_name") String search_name){
        if(search_name==null||search_name==""){
            return "redirect:/listPersonByPage";
        }else{
            search_name = search_name.trim();
            List<Person> list = personService.searchByPersonName(search_name);
            model.addAttribute("list",list);
            return "listPersonPage";
        }
    }

    @RequestMapping(value = "/listPersonByPage")
    public String listPersonByPage(Model model,@RequestParam(value = "currentPage",defaultValue = "0") int currentPage){
        int pageSize = 5;//每页记录数
        if(currentPage == 0){
            currentPage =1 ;
        }

        //创建一个page对象
        int totalCount = personService.getTotalCount();//得到总记录数
        Page page = new Page(pageSize, currentPage, totalCount);
        //获取list
        List<Person> list = personService.findPersonByPage(page);

        model.addAttribute("page",page);
        model.addAttribute("list",list);
        return "listPersonPage";
    }

    @RequestMapping(value = "/personLogin",method = RequestMethod.POST)
    public String login(Person person,Model model){
        if(person.getUsername()=="" || person.getPassword()==""){
            model.addAttribute("msg","用户名或密码不可为空！");
            return "loginPage";
        }//输入为空时

        Person db_person = loginService.login(person);
        if(db_person==null){
            model.addAttribute("msg","不存在该用户名！");
            return "loginPage";
        }//在数据库中查询不到时

        if(db_person.getUsername().equals(person.getUsername()) && db_person.getPassword().equals(person.getPassword())){
            return "redirect:/listPersonByPage";
        }//成功登录

        model.addAttribute("msg","密码错误！");
        return "loginPage";//除了正确的用户名和密码 都跳转到登录页面
    }

//    @RequestMapping(value = "test")
//    public String springTest(){
//        return testService.test();
//    }

}
