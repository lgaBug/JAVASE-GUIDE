package com.lga.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
        @Result(name = "input",location = "/WEB-INF/user/flag.jsp"),
        @Result(name = "error",location = "/WEB-INF/error.jsp")
})
public class FlagAction extends ActionSupport {

    private Boolean flag;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Action(value = "/flag")
    public String flagIndex(){
        this.flag = true;
        //int i = 3 / 0;
        return "input";
    }

}
