package com.hub;

import com.esotericsoftware.yamlbeans.YamlException;
import com.hub.util.YamlReadUtils;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class testTest {

    @Test
    public void test1(){
        try {
            List list = YamlReadUtils.getStepList("data/testBaidu.yaml");
            for(int i = 0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (YamlException e) {
            e.printStackTrace();
        }

    }
}
