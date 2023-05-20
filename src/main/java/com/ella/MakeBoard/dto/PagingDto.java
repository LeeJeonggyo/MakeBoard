package com.ella.MakeBoard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
public class PagingDto {
    // 페이징
    protected Long totalElements;   // 전체 행 수
    protected Integer size;         // 페이지 당 행 수
    protected Integer pageNumber;   // 현재 페이지
    protected Long offset;          // 페이징 시작 수

    /**
     * 페이징 정보 dto 전환
     * @param page
     * @return PagingDto
     * @param <T>
     */
    public <T> PagingDto pagingDto(Page<T> page){
        PagingDto pagingDto = new PagingDto();
        pagingDto.setTotalElements(page.getTotalElements());            // 전체 행 수
        pagingDto.setSize(page.getSize());                              // 페이지 당 행 수
        pagingDto.setPageNumber(page.getPageable().getPageNumber());    // 현재 페이지
        pagingDto.setOffset(page.getPageable().getOffset());            // 페이징 시작 수
        return pagingDto;
    }
}
