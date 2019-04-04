package com.d1m.elasticsearch.util.PageUtil;


import lombok.Data;

import java.util.List;


@Data
public class PageBean {

    private int currentPage;
    private int pageSize;
    private int totalPages;
    private Long totalCounts;
    private List data;


    public static PageBean createPageBean(int currentPage,int pageSize,Long totalCounts,List list){
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCounts(totalCounts);
        if (pageSize == 0){
            pageBean.setTotalPages(999999999);
        }else {
            Long totalPages = (totalCounts + pageSize -1)/pageSize;
            pageBean.setTotalPages(totalPages.intValue());
        }
        pageBean.setData(list);
        return pageBean;
    }
}
