package com.rhabad.peluqueria_canina.services;

import com.rhabad.peluqueria_canina.repositories.AtencionEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtencionEspecialService {

    private AtencionEspecialRepository atencionEspecialRepository;

    @Autowired
    public AtencionEspecialService(AtencionEspecialRepository atencionEspecialRepository){
        this.atencionEspecialRepository = atencionEspecialRepository;
    }


    //crear nuevo registro de atencionEspecial

}
