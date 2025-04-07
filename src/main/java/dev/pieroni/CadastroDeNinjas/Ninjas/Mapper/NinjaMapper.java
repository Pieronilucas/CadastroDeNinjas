package dev.pieroni.CadastroDeNinjas.Ninjas.Mapper;


import dev.pieroni.CadastroDeNinjas.Ninjas.DTO.NinjaDTO;
import dev.pieroni.CadastroDeNinjas.Ninjas.Model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjadto) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjadto.getId());
        ninjaModel.setName(ninjadto.getName());
        ninjaModel.setEmail(ninjadto.getEmail());
        ninjaModel.setImgUrl(ninjadto.getImgUrl());
        ninjaModel.setAge(ninjadto.getAge());
        ninjaModel.setRank(ninjadto.getRank());
        ninjaModel.setMissions(ninjadto.getMissions());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjamodel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjamodel.getId());
        ninjaDTO.setName(ninjamodel.getName());
        ninjaDTO.setEmail(ninjamodel.getEmail());
        ninjaDTO.setImgUrl(ninjamodel.getImgUrl());
        ninjaDTO.setAge(ninjamodel.getAge());
        ninjaDTO.setRank(ninjamodel.getRank());
        ninjaDTO.setMissions(ninjamodel.getMissions());

        return ninjaDTO;
    }
}
