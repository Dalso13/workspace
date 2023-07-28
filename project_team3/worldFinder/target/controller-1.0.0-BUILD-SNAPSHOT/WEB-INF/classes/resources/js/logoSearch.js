let countrys = "";
    $.ajax({
        url: "/logoSeach",
        dataType: "json",
        type: "get",
        async: false,
        success: function (datas) {
            countrys = datas;
        },
    })
