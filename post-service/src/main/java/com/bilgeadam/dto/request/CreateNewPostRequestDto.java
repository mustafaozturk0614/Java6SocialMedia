package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNewPostRequestDto {

    private String userId;
    private String username;
    private String title;
    private String content;
    private String mediaUrl;
}
