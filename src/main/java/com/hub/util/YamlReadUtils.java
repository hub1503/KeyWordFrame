package com.hub.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

public class YamlReadUtils {

    /**
     * @param path
     *            对象库文件地址
     * @param pageName
     *            页面名字
     * @return 返回locator 哈希表 locatorName:locator
     */
    public static List<Step> getStepList(String path)
            throws FileNotFoundException, YamlException {
        List<Step> stepList = new ArrayList<Step>();

        YamlReader yamlReader = new YamlReader(new FileReader(path));
        Object yamlObject = yamlReader.read();
        Map<?, ?> yamlMap = (Map<?, ?>) yamlObject;
        @SuppressWarnings("unchecked")
        ArrayList<HashMap<String, Object>> pages = (ArrayList<HashMap<String, Object>>) yamlMap.get("steps");
        for (int i = 0; i < pages.size(); i++)// 遍历Page节点
        {
            HashMap<String, Object> pageNode = pages.get(i);// 获取page节点
            @SuppressWarnings("unchecked")
            HashMap<String, Object> pageElement = (HashMap<String, Object>) pageNode.get("step");
            Step step = new Step();
            step.setDesc(pageElement.get("desc").toString());
            step.setKeyWord(pageElement.get("keyWord").toString());
            step.setParam(pageElement.get("param").toString());
            step.setResult(pageElement.get("result").toString());
            Locator locator = new Locator();
            if("" != pageElement.get("element").toString() && null != pageElement.get("element").toString()) {
                String type = pageElement.get("element").toString().split(":")[0];
                String value = pageElement.get("element").toString().split(":")[1];
                locator.setByType(getByType(type));
                locator.setValue(value);
            }
            step.setlocator(locator);
            stepList.add(step);
        }
        return stepList;
    }

    /**
     * @param type
     */
    public static Locator.ByType getByType(String type) {
        Locator.ByType byType = Locator.ByType.xpath;
        if (type == null || type.equalsIgnoreCase("xpath")) {
            byType = Locator.ByType.xpath;
        } else if (type.equalsIgnoreCase("id")) {
            byType = Locator.ByType.id;
        } else if (type.equalsIgnoreCase("linkText")) {
            byType = Locator.ByType.linkText;
        } else if (type.equalsIgnoreCase("name")) {
            byType = Locator.ByType.name;
        } else if (type.equalsIgnoreCase("className")) {
            byType = Locator.ByType.className;
        } else if (type.equalsIgnoreCase("cssSelector")) {
            byType = Locator.ByType.cssSelector;
        } else if (type.equalsIgnoreCase("partialLinkText")) {
            byType = Locator.ByType.partialLinkText;
        } else if (type.equalsIgnoreCase("tagName")) {
            byType = Locator.ByType.tagName;
        }
        return byType;
    }
}
