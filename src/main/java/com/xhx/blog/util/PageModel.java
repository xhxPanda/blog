package com.xhx.blog.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PageModel
{

    // 放对象的list
    private List list = new ArrayList();
    // 当前页
    private int currentPage = 1;
    // 总页数
    private int totalPage;
    // 总记录条数
    private int totalCount;
    // 每页的记录数量
    private int pageSize;
    

    public PageModel()
    {
        this.currentPage = Integer.valueOf(1);
        this.totalCount = Integer.valueOf(0);
        this.pageSize = Integer.valueOf(10);
    }

    // -- 构造函数 初始pageSize --//
    public PageModel(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getBeginIndex()
    {
        return (this.currentPage - 1) * this.pageSize;
    }

    // 设置当前页的页号,序号从1开始,低于1时自动调整为1.
    public int getCurrentPage()
    {
        return this.currentPage < 1 ? 1 : this.currentPage;
    }

    // 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
    public int getFirst()
    {
        return this.currentPage * this.pageSize - this.pageSize + 1;
    }

    public List getList()
    {
        return this.list;
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public int getTotalCount()
    {
        return this.totalCount;
    }

    public int getTotalPage()
    {
        if (this.totalCount < 0)
        {
            return -1;
        }

        int count = this.totalCount / this.pageSize;
        if (this.totalCount % this.pageSize > 0)
        {
            count++;
        }
        return count == 0 ? 1 : count;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage < 1 ? 1 : currentPage;
    }

    public void setList(List list)
    {
        this.list = list;
    }

    // 设置每页的记录数量,低于1时自动调整为1
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize < 1 ? 1 : pageSize;
    }

    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

}
