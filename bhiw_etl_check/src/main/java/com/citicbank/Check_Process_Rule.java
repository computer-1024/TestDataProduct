package com.citicbank;

public class Check_Process_Rule {

    private String[] array_data;

    public Check_Process_Rule() {
    }

    public void setArray_data(String[] array_data) {
        this.array_data = array_data;
    }

    //检查新增实体的配置
    public boolean process_add_entity()
    {
        return  array_data[2].substring(0,6).equalsIgnoreCase("bhif_t") //匹配实体表名
                && array_data[3].equalsIgnoreCase("T") // array_data[3] 模型类型
                && array_data[4].equalsIgnoreCase("新增实体")   // array_data[4] 变更类型
                && array_data[5].equalsIgnoreCase("Y")  // array_data[5] 是否更新DDL
                && array_data[6].equalsIgnoreCase("N")  // array_data[6] 是否备份DDL
                && array_data[7].equalsIgnoreCase("Y")  // array_data[7] 是否更新GSQL
                && array_data[8].equalsIgnoreCase("N")  // array_data[8] 是否备份GSQL
                && array_data[9].equalsIgnoreCase("Y"); // array_data[9] 是否更新调度
    }

    //检查修改实体的配置
    public boolean process_modify_entity()
    {
        return  array_data[2].substring(0,6).equalsIgnoreCase("bhif_t") //匹配实体表名
                && array_data[3].equalsIgnoreCase("T") // array_data[3] 模型类型
                && array_data[4].equalsIgnoreCase("实体变更")   // array_data[4] 变更类型
                && array_data[5].equalsIgnoreCase("Y")  // array_data[5] 是否更新DDL
                && array_data[6].equalsIgnoreCase("N")  // array_data[6] 是否备份DDL
                && array_data[7].equalsIgnoreCase("Y")  // array_data[7] 是否更新GSQL
                && array_data[8].equalsIgnoreCase("N")  // array_data[8] 是否备份GSQL
                && array_data[9].equalsIgnoreCase("Y"); // array_data[9] 是否更新调度
    }


    //检查新增视图的配置
    public boolean process_add_view()
    {
        return  array_data[2].substring(0,6).equalsIgnoreCase("bhif_v") //匹配视图名称
                && array_data[3].equalsIgnoreCase("V")  // array_data[3] 模型类型
                && array_data[4].equalsIgnoreCase("新增视图")    // array_data[4] 变更类型
                && array_data[5].equalsIgnoreCase("Y")   // array_data[5] 是否更新DDL
                && array_data[6].equalsIgnoreCase("N")  // array_data[6] 是否备份DDL
                && array_data[7].equalsIgnoreCase("N")  // array_data[7] 是否更新GSQL
                && array_data[8].equalsIgnoreCase("N")  // array_data[8] 是否备份GSQL
                && array_data[9].equalsIgnoreCase("N"); // array_data[9] 是否更新调度
    }

    //检查修改视图的配置
    public boolean process_modify_view()
    {
        return  array_data[2].substring(0,6).equalsIgnoreCase("bhif_v") //匹配视图名称
                && array_data[3].equalsIgnoreCase("V")  // array_data[3] 模型类型
                && array_data[4].equalsIgnoreCase("视图变更")    // array_data[4] 变更类型
                && array_data[5].equalsIgnoreCase("Y")   // array_data[5] 是否更新DDL
                && array_data[6].equalsIgnoreCase("N")  // array_data[6] 是否备份DDL
                && array_data[7].equalsIgnoreCase("N")  // array_data[7] 是否更新GSQL
                && array_data[8].equalsIgnoreCase("N")  // array_data[8] 是否备份GSQL
                && array_data[9].equalsIgnoreCase("N"); // array_data[9] 是否更新调度
    }



    public boolean process_check() {
        return process_add_entity()||process_add_view()||process_modify_entity()||process_modify_view();
    }

    public String process_rst_print() {
        return array_data[2].toUpperCase() + (process_check()? ":流程化配置检查通过":":流程化配置检查不通过");
    }
}
