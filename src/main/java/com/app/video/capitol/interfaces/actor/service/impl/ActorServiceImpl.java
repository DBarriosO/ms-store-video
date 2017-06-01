/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.video.capitol.interfaces.actor.service.impl;

import com.app.video.capitol.dominio.actor.Actor;
import com.app.video.capitol.dominio.actor.ActorRepository;
import com.app.video.capitol.interfaces.actor.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("ActorService")
@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Override
    public Actor findById(Long id) {
        return actorRepository.findOne(id);
    }

}
