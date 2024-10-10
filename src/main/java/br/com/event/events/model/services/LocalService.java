package br.com.event.events.model.services;

import br.com.event.events.model.entities.Local;
import br.com.event.events.model.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalService {

    private final LocalRepository localRepository;

    @Autowired
    public LocalService(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    public Local save(Local local){
        return localRepository.save(local);
    }

    public Local getLocalById(Long id){
        return localRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local not found"));
    }
}
