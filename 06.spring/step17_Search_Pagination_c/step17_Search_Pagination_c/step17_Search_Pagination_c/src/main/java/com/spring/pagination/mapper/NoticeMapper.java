package com.spring.pagination.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.pagination.dto.Notice;
import com.spring.pagination.dto.PageRequestDTO;
import com.spring.pagination.dto.SearchKeyword;


@Mapper
public interface NoticeMapper {

	// insertNotice
	public Integer insertNotice(Notice notice);
	
	// searchKeyword
	public List<Notice> getNoticeBySearchKeyword(SearchKeyword searchKeyword);
	
	// pagination
	public List<Notice> getNoticeByPagination(PageRequestDTO pageRequest);
	
	// total data count 전
//		public int getTotalCount();
		
	// total data count 후
	public int getTotalCount(PageRequestDTO pageRequest);

	// search + pagination
	public List<Notice> getNoticeWithPageRequest(PageRequestDTO pageRequest);

	
}
