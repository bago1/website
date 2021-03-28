package com.feedback.website.dtos;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDto {

    public String ad;
    public String soyad;
    public String email;
    public String password;
    public List<CommentDto> commentsDto;

//todo niye fieldleri private edib, @getter seetterveya @data yazanda mapping ede bilmir Usermapper interfaesi. Impl fayli yaranmir/ mecbur public edirik
}