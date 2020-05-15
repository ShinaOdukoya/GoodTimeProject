package com.goodTime.demainobject;

import org.springframework.data.rest.core.config.Projection;
import com.goodTime.model.Music;


@Projection(name="musicDetails", types= {Music.class})
public interface MusicResponseObject {

}
