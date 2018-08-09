package com.itec.clinic.entity;

public class Page {
    //每页显示数
    private int pageSize;
    //全部记录数
    private int totalCount;
    //全部页数
    private int totalPage;
    //当前页数
    private int currentPage;
    //起始点
    private int beginIndex;

    public Page(){

    }

    public Page(int pageSize, int currentPage, int totalCount){
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.setBeginIndex(pageSize,currentPage);//计算起始行
        this.setTotalPage(pageSize,totalCount);//计算总页数
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    /*
    * 计算总页数
    * @param pageSize
    * @param totalCount*/
    public void setTotalPage(int pageSize,int totalCount){
        if(totalCount == 0){
            this.totalPage = 1;
        }else if(totalCount % pageSize == 0 ){
            this.totalPage = totalCount / pageSize; //若没有余数 则取整即可
        }else {
            this.totalPage = totalCount / pageSize + 1; //若有余数 则取整加1
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    /*
     * 计算起始行
     * @param pageSize
     * @param currentPage
     * */
    public void setBeginIndex(int pageSize, int currentPage){
         this.beginIndex = (currentPage - 1) * pageSize;
    }

}
