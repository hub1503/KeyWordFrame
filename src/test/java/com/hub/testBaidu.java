package com.hub;

import com.hub.util.BaseAction;
import com.hub.util.Step;
import com.hub.util.WaitUtil;
import com.hub.util.YamlReadUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

public class testBaidu {

    BaseAction action = new BaseAction();
    Method[] methods = action.getClass().getMethods();
    @Test
    public void testBaidu() throws Exception{
        List<Step> list = YamlReadUtils.getStepList("data/"+this.getClass().getSimpleName()+".yaml");
        for(int i = 0;i<list.size();i++){
            for(int j = 0;j<methods.length;j++){
                if(list.get(i).getKeyWord().equalsIgnoreCase(methods[j].getName())){
                    methods[j].invoke(action,list.get(i).getlocator(),list.get(i).getParam());
                }
            }
        }
    }
    @AfterTest
    public void quite(){
        action.quite();
    }
}
