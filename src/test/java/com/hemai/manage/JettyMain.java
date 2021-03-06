package com.hemai.manage;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyMain {
    public static void main(String[] args) throws Exception {
        Integer port = 8080;
        String war = "src/main/webapp";
        String contextPath = "/manage";

        if (args.length > 0) {
            String portText = args[0];
            port = Integer.parseInt(portText);
        }

        if (args.length > 1) {
            war = args[1];
        }

        if (args.length > 2) {
            contextPath = args[2];
        }

        Server jettyServer = new Server();
        ServerConnector conn = new ServerConnector(jettyServer);
        conn.setPort(port);
        jettyServer.setConnectors(new Connector[]{conn});
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(contextPath);
        webAppContext.setWar(war);
        jettyServer.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize",-1);
        jettyServer.setHandler(webAppContext);
        System.out.println("server is  start");
        try {
            jettyServer.start();
            jettyServer.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        }
        }