package com.ballestax.miamiapi.service;


import com.ballestax.miamiapi.model.Presentation;

import java.util.List;

public interface PresentationService {

    Presentation savePresentation(Presentation presentation);

    List<Presentation> getAllPresentations();

    List<Presentation> getAllPresentationsByProductId(Long productId);

    Presentation getPresentationById(long id);

    Presentation updatePresentation(Presentation presentation, long id);

    void delete(long id);

}
