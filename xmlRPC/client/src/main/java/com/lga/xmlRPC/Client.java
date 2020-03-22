package com.lga.xmlRPC;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {

    public static void main(String[] args) throws IOException {
        try {

            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://127.0.0.1:9999/tomcat_server_war/service"));

            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            Object[] params = new Object[]{new Integer(31), new Integer(9)};
            Integer result = (Integer) client.execute("MyMethodHandler.add", params);
            Integer result1 = (Integer) client.execute("MyMethodHandler.sub", params);

            System.out.println(result);
            System.out.println(result1);


        } catch (XmlRpcException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
