package org.kodluyoruz.group1.library.converter;

import org.modelmapper.ModelMapper;

public interface BaseConverter<E, D> {

    D convert(E entity);

}
