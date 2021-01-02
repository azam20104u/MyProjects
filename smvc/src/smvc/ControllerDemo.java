package smvc;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerDemo {
	@Autowired
	Demo d;
	@RequestMapping("/link1")
	public ModelAndView m1(){
		return new ModelAndView("demo1","hi","Hi this is Text");
	}
	@RequestMapping("/link2")
	public ModelAndView m2(){
		d.setId(123);
		d.setName("Narendra");
		return new ModelAndView("demo2","d",d);
	}
	@RequestMapping("/link3")
	public ModelAndView m3(){
		ArrayList<Demo> list=new ArrayList();
		list.add(new Demo("Azam",123));
		list.add(new Demo("Amir",124));
		list.add(new Demo("Reza",125));
		return new ModelAndView("demo5","list",list);
	}
	@RequestMapping("/l1")
	public ModelAndView t1(@RequestParam String hi){
		return new ModelAndView("demo3","hi",hi);
	}
	@Autowired
	SessionFactory sf;
	@RequestMapping(value="/l2",method=RequestMethod.POST)
	public ModelAndView t2(@ModelAttribute Demo d){
		Session ss=sf.openSession();
		ss.save(d);
		ss.beginTransaction().commit();
		ss.close();
		return new ModelAndView("demo4","d",d);
	}
}
