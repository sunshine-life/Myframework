define(['jquery', 'bootstrap', 'layout2', 'select2', 'validate', 'toastr'], function () {
    var index = {
        init : _init,
    };
    function _init(){
        bindEvents();
    }
    /**
     * 绑定事件
     */
    function bindEvents() {
        $('#search').on("click",function(){
            alert("调用了方法！");
            _test(1);
        });
    }
    function _test(ids){
        var text = {"datas":[{"h1": {"name":"hehe","age":1}},{"h2":{"name":"hehe2","age":2}}]};
        var data= JSON.stringify(text);
        alert(data);
        /*var text = {
            name:"xinzeng",
            age:10
        };*/
        $.ajax({
            type: "POST",
            url: "/myTest/get",
            data: "text="+ data,
            success : function(data) {
                //alert(data[0].name)
                alert("操作成功！")
                //toastr.success("操作成功");
            }
        });
    }
    return index;
});