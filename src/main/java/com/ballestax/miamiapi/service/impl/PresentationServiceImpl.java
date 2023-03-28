package com.ballestax.miamiapi.service.impl;


import com.ballestax.miamiapi.exception.ResourceNotFoundException;
import com.ballestax.miamiapi.model.Presentation;
import com.ballestax.miamiapi.repository.PresentationRepository;
import com.ballestax.miamiapi.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PresentationServiceImpl implements PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    @Override
    public Presentation savePresentation(Presentation presentation) {
        return presentationRepository.save(presentation);
    }

    @Override
    public List<Presentation> getAllPresentations() {
        return presentationRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Presentation> getAllPresentationsByProductId(Long productId) {
        return presentationRepository.findPresentationsByProductId(productId);
    }

    @Override
    public Presentation getPresentationById(long id) {
        return presentationRepository.findById(id)
                .orElseThrow(()->
                new ResourceNotFoundException("Presentation", "id", id));
    }

    @Override
    public Presentation updatePresentation(Presentation presentation, long id) {
        Presentation existingPresentation = presentationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Presentation", "id", id)
        );
        existingPresentation.setName(presentation.getName());
        existingPresentation.setPrice(presentation.getPrice());
        existingPresentation.set_enabled(presentation.is_enabled());

        presentationRepository.save(existingPresentation);
        return existingPresentation;

    }

    @Override
    public void delete(long id) {
        presentationRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Presentation", "Id", id));
        presentationRepository.deleteById(id);
    }
}
