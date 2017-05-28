package com.rafacost3d.bbs_mod.init;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;
import com.rafacost3d.bbs_mod.BBSMod;

import java.io.InputStreamReader;
import java.net.URL;

public class BBSGetMarketDataFireBase extends Thread {

    public static BBSGetMarketDataFireBase activeThread;

    public BBSGetMarketDataFireBase(){
        setName("Beer Brewing Simulator Market Data");
        setDaemon(true);
        start();
        activeThread=this;
    }

    @Override
    public void run(){
        Gson gson = new Gson();
        try {
            BBSMod.logger.info("Attempting to download Today's Market Data from FireBase Server");
            URL url = new URL("https://tbbs-be97f.firebaseio.com/market_data.json");
            JsonStreamParser parser = new JsonStreamParser(new InputStreamReader(url.openStream()));
            while(parser.hasNext()) {
                try{
                    JsonElement je = parser.next();
                    BBSMarketData market = gson.fromJson(je, BBSMarketData.class);
                    if(market!=null) {
                        //Minecraft.getMinecraft().player.sendChatMessage(market.beerType);
                        BBSMod.logger.info("This week the Market wants to buy " + market.beerType + ": " + market.quantity.toString() + " bottles @ MaxPrice:" + market.maxPrice.toString());
                    }

                }catch(Exception exParse) {
                    BBSMod.logger.warn("Error on parsing Today's Market Data");
                    exParse.printStackTrace();
                }
            }
        } catch(Exception e) {
            BBSMod.logger.warn("Could not load Today's Market Data");
            e.printStackTrace();
        }

    }
}
