package com.ceit.desktop.utils;

import net.juniper.netconf.Device;
import net.juniper.netconf.NetconfException;
import net.juniper.netconf.XML;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.util.*;

public class NetconfUtils {

    private static final String HOSTNAME = "192.168.109.223";
    private static final String USERNAME = "client001";
    private static final String PASSWORD = "abcd1234";
    private static final int NETCONF_PORT = 55555;

    /**
     * 要发送的xml报文 例如：
     * <get>
     * <filter type="subtree">
     * <users xmlns="http://netconfcentral.org/ns/user">
     * <user>
     * <name>admin</name>
     * </user>
     * </users>
     * </filter>
     * </get>
     *
     * @param xmlContent
     * @return
     */
    public static XML send(String xmlContent) throws NetconfException {

        Device device = null;

        XML xmlReply = null;

        try {
            device = Device.builder().hostName(HOSTNAME)
                    .userName(USERNAME)
                    .password(PASSWORD)
                    .port(NETCONF_PORT)
                    .strictHostKeyChecking(false)
                    .hostKeysFileName(null)
                    .build();
            device.connect();

            xmlReply = device.executeRPC(xmlContent);
            device.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NetconfException("报文发送失败");
        } finally {
            if (null != device) {
                device.close();
            }
        }
        return xmlReply;
    }


    public static XML send(String deviceHOSTNAME, String deviceUSERNAME, String devicePASSWORD, int deviceNETCONFPORT
            , String xmlContent) throws NetconfException {

        Device device = null;

        XML xmlReply = null;

        try {
            device = Device.builder().hostName(deviceHOSTNAME)
                    .userName(deviceUSERNAME)
                    .password(devicePASSWORD)
                    .port(deviceNETCONFPORT)
                    .strictHostKeyChecking(false)
                    .hostKeysFileName(null)
                    .build();
            device.connect();

            xmlReply = device.executeRPC(xmlContent);
            device.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NetconfException("报文发送失败");
        } finally {
            if (null != device) {
                device.close();
            }
        }
        return xmlReply;
    }
    public static List<Object> parseXml(Document doc, String xpath, String key){
        List<Object> result = null;
        Map map = new HashMap();
        String nsURI = doc.getRootElement().getNamespaceURI();
        map.put("xmlns",nsURI);

        XPath x = doc.createXPath(xpath);
        x.setNamespaceURIs(map);
        List<Node> nodes = x.selectNodes(doc);
        if (nodes != null && nodes.size() > 0)
        {
            result = new ArrayList<Object>();
            for (Node node : nodes)
            {
                Element element = (Element)node;
                String s1 = element.element(key).getText();
                result.add(s1);
                System.out.println(s1);
            }
        }
        return  result;
    }
    public static Object parseXml(XML xmlReply, String key){
        String xml = xmlReply.toString();
        Map<String, String> map = new HashMap<String,String>();
        parseXml2Map(xml,map);
        System.out.println("xml2map:"+map);
        if(map.get(key) == ""){
            return -1;
        }
        if(map.get(key) == null){
            return -2;
        }

        return map.get(key);
    }

    /**
     * 将xml转换为Map。 支持xml标签多层嵌套，并以"."分隔多级标签（不包括根节点）。 不支持XML标签重复时的情况
     *
     * @param xml
     * @param map
     * @return
     */
    public static Map<String, String> parseXml2Map(String xml, Map<String, String> map) {
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new StringReader(xml));
            Element root = doc.getRootElement();
            String path = "";
            if (map.containsKey(root.getName().trim())) {
                path = map.get(root.getName().trim());
                map.remove(root.getName().trim());
            }
            for (Iterator i = root.elementIterator(); i.hasNext();) {
                Element element = (Element) i.next();
                if (element.isTextOnly()) {
                    if (path.length() > 0) {
                        map.put(path + element.getName().trim(), element.getTextTrim());
                    } else {
                        map.put(element.getName().trim(), element.getTextTrim());
                    }
                } else {
                    map.put(element.getName().trim(), path+ element.getName().trim() + ".");
                    parseXml2Map(element.asXML(), map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static List<String> xml2maclist(String xml){
        try{
            List<String> result = null;
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new StringReader(xml));
            Map map = new HashMap();
            String nsURI1 = doc.getRootElement().getNamespaceURI();
            map.put("xmlns1",nsURI1);
            XPath x = doc.createXPath("/xmlns1:rpc-reply/xmlns1:data");
            x.setNamespaceURIs(map);
            String nsURI2 = ((Element)x.selectSingleNode(doc)).element("mac-address-table-get").getNamespaceURI();
            map.put("xmlns2",nsURI2);

            XPath x1 = doc.createXPath("/xmlns1:rpc-reply/xmlns1:data/xmlns2:mac-address-table-get/xmlns2:mac-address-details");

            x1.setNamespaceURIs(map);

            List<Node> nodes = x1.selectNodes(doc);

            if (nodes != null && nodes.size() > 0)
            {

                result = new ArrayList<String>();
                for (Node node : nodes)
                {
                    Element element = (Element)node;
                    String s1 = element.element("mac-address").getText();

                    result.add(s1);
                    System.out.println(s1);
                }
            }
            return  result;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
