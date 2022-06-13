
   $("#import").click(function(){
          $.ajax({
              type: 'GET',
              url: 'http://localhost:8081/import',
              dataType : "json",
              contentType:"application/json",
              success: function(data){
                    alert("imported");
              },
              error: function (xhr, ajaxOptions, thrownError) {
                    alert("error")

              }
          });
    });


