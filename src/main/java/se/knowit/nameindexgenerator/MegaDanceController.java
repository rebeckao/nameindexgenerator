package se.knowit.nameindexgenerator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MegaDanceController {

    @RequestMapping(value = "/greeting",method= RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return "Hello " + generateNameIndex(name);
    }

    protected boolean isSameName(String name1, String name2) {
        String nameIndex1 = generateNameIndex(name1);
        String nameIndex2 = generateNameIndex(name2);

        return nameIndex1.equals(nameIndex2);

    }

    private String generateNameIndex(String name){
        String s = name.toLowerCase();
        // Dubbelnamn
        s = s.replaceAll("e-", "");
        s = s.replaceAll("a-", "");
        s = s.replaceAll("h-", "");
        s = s.replaceAll("-", "");
        s = s.replaceAll("e ", "");
        s = s.replaceAll("a ", "");
        s = s.replaceAll("h ", "");
        s = s.replaceAll(" ", "");
        return s;
    }
}
