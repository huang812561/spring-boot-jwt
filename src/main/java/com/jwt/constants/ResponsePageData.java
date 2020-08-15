package com.jwt.constants;

/**
 * @Decription：返回分页参数
 * @Author： huang_guoqiang
 * @Date 2019年05月10日 9:25
 * @Version 1.0
 */
public class ResponsePageData extends ResponseData {

    /**
     * 分页大小
     */
    private int pageSize;
    /**
     * 分页索引
     */
    private int pageIndex;
    /**
     * 分页的总页数
     */
    private int totalPage;
    /**
     * 分页总条数
     */
    private int totalCount;

}
