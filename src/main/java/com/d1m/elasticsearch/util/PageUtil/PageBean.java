package com.d1m.elasticsearch.util.PageUtil;


import lombok.Data;

import java.util.List;


@Data
public class PageBean {

    private List list; // 要返回的某一页得记录
    private int currentPage; // 当前页
    private int pageSize; // 每页记录数
    private boolean isLastPage;
    private int totalPages;
    private Long totalCounts;


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
        pageBean.setList(list);
        return pageBean;
    }
}
