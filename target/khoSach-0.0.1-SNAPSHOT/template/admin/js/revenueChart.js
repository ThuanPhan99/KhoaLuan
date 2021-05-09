function check(){
	    		var day = new Date();
	    		var nam =[];
	    		for(var i=2016;i<=day.getFullYear();i++){
	    			nam.push(i);
	    		}
	    		return nam;
	    	}
	    	function data(){
	    		var data =[];
	    		var ih = $('#revenue').val();
	    		   var info = $("#revenue").val().split(',');
	    		   for(var i=0;i<info.length;i++){
	    		   			data.push(info[i]);
	    		   }
	    		return data;
	    	}
           new Chart(document.getElementById("line-chart"), {
        	  type: 'line',
        	  data: {
        	    labels: check(),
        	    datasets: [{ 
        	        data: data(),
        	        label: "doanh thu",
        	        borderColor: "#ff5800",
        	        fill: false
        	      }
        	    ]
        	  },
        	  options: {
        	    title: {
        	      display: true,
        	      text: 'Biểu đồ doanh thu (VNĐ)'
        	    }
        	  }
        	});