package com.lga.xmlRPC;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.server.XmlRpcStreamServer;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class Server {

    private static final int port = 9999;

    public static void main(String[] args) throws IOException, XmlRpcException {

        WebServer webServer = new WebServer(port);

        XmlRpcStreamServer xmlRpcServer = webServer.getXmlRpcServer();
        PropertyHandlerMapping propertyHandlerMapping = new PropertyHandlerMapping();
        propertyHandlerMapping.load(Server.class.getClassLoader(),"MyHandlers.properties");
        xmlRpcServer.setHandlerMapping(propertyHandlerMapping);

        XmlRpcServerConfigImpl xmlRpcServerConfig = new XmlRpcServerConfigImpl();
        xmlRpcServerConfig.setEnabledForExceptions(true);
        xmlRpcServerConfig.setEnabledForExtensions(true);
        xmlRpcServer.setConfig(xmlRpcServerConfig);


        webServer.start();


    }
}
