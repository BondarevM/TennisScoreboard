package com.bma.service;

import com.bma.dao.PlayerDao;
import com.bma.model.Player;

import java.util.List;

public class PlayerService {
    private final PlayerDao playerDao = PlayerDao.getInstance();


    public List<Player> findAll(){

       return playerDao.findAll();
    }



    private static final PlayerService INSTANCE = new PlayerService();
    private PlayerService(){}
    public static PlayerService getInstance(){
        return INSTANCE;
    }

}
