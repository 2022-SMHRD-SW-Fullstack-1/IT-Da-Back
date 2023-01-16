package or.kr.smhrd.portal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/announcement")
@RestController
public class TMainController {

   @PostMapping("/detail")
   public String name() {
      System.out.println("hi");
      return "asdf";
   }

}
