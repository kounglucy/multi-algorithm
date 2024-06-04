<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - S</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">


      
		
		
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
				

				
				
                <!-- Topbar -->
                
          
                
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                     	class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <span>STOCKS MARKET</span>
                    </form>
				  <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/index">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Go back to main page</div>
        		    </a>
				
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">



                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${ sessionScope.user_name}</span>
                                <img class="img-profile rounded-circle"
                                    src="/resources/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/logout" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                 <!-- Nav Item - Tables -->

                <div class="container-fluid">
					
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                  
                        <h1 class="h3 mb-0 text-gray-800">${stocks.company_name}</h1>
                      
                    </div>

                    <!-- Content Row -->
                   
                    <div class="row">
                         

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                           <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                               	계좌금액</div>
 										<div class="h5 mb-0 font-weight-bold text-gray-800">${ sessionScope.user_money}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                               	거래가격</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${ stocks.price}₩</div>
                                            
                                            
                                            <!-- 등락율  ----------------------------------------------------------------------                      -->                                        
                                            
                                            <div class="countBox">
										        <p class="countNumber">0%</p>
										        <div class="countButtonWrap">
										            <button class="generate">Refresh</button>
										        </div>
										    </div>
										    
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">매수
                                            </div>
                                           
                                                
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
                                   		 
												<input type="number" id="volume1" name="volume" min=1 value=1>
												<a href="javascript:buy('${stocks.stocks_code}', '${stocks.price}')" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
												매수</a>
										
                                                    </div>
                                                

                                            </div>
                                        
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </div>
						 <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">매도
                                            </div>
                                           
                                                
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
                                   		 
												<input type="number" id="volume2" name="volume" min=1 value=1>
												<a href="javascript:sell('${stocks.stocks_code}', '${stocks.price}')" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
												매도</a>
										
                                                    </div>
                                                

                                            </div>
                                        
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </div>
						
                        <!-- Pending Requests Card Example -->
                        
                       
                    <!-- Content Row -->

                  <!-- Pie Chart -->
                    <div class="row">

                      <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">자산/부채 비율 그래프</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> 자산총계
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> 부채총계
                                        </span>
                                     
                                    </div>
                                </div>
                            </div>
                        </div>

	

						<!-- 그래프2 -->
                      <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">거래량 그래프</h6>
                                    <div class="dropdown no-arrow">
                                        <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
                                            aria-labelledby="dropdownMenuLink">
                                            <div class="dropdown-header">Dropdown Header:</div>
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </div>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart2"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-primary"></i> 전체 거래량
                                        </span>
                                        <span class="mr-2">
                                            <i class="fas fa-circle text-success"></i> ${stocks.company_name } 거래량
                                        </span>
                                     
                                    </div>
                                </div>
                            </div>
                        </div>
                     						  <span> Details of ${stocks.company_name} <br>
 						  In Millions of KRW(except for dept ratio) <br>
 						  <br>
 						  more details <br>
 						  <a target = "_blank" rel = "nofollow" href = "https://www.investing.com/">https://www.investing.com/</a>
 						  
 						  </span> 
 						  
 						  
 						  <!-- 카드 -->
 						  <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                               	Asset</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${stocks.asset} <br>
                                            
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                               	Debt</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${stocks.debt}</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Sales
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${stocks.sales}</div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                               	Debt Ratio</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${stocks.debt/stocks.asset*100}%</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
 						  
 						  
 						  
 						  
 						  
 						  
 						  
                    </div>
                    
                    
                    
                    <div class = "row">
                    					
                      <div class="row">
                         

                        




                    </div>
                    
                    </div>
                    
                    
                    
                    
                    
                    
                    
                    
                    
					                        <!-- 검색 -->

                        
		
					
                    <!-- 테이블 -->
					 <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Transaction History</h1>
                    <p class="mb-4">Following table is for showing all investors' transaction data.
                    </p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">주식시장 거래내역</h6>
                        </div>
                        
                        

                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>거래번호</th>
                                            <th>투자자명</th>
                                            <th>주식번호</th>
                                            <th>구매개수</th>
                                            <th>거래가격</th>
                                            <th>매도/매수</th>

                                        </tr>
                                    </thead>
                                 
                                    <tbody>
                            		<c:forEach items="${requestScope.trading}" var="trading">
		   							 <tr>
		     						   <td bgcolor="">
		         						   <p align="center">
			      						      <span style="font-size:12pt;">
			       						     	
			       						     	<b>${trading.trading_id}</b>
			 						           </span>
		  						          </p>
		  						      </td>
		  						      
								        <td bgcolor="">
								            <p align="center">
							            	<span style="font-size:12pt;">
							            		
							             		<b>${trading.user_id}</b>
		        						     </span>
								             </p>
								        </td>
								        
								        
		  						      <td bgcolor="">
											<p align="center">
												<span style="font-size:12pt;">
					
												<b>${trading.stocks_code}</b>
											</span>
											</p>
		  						      </td>
		  						      
								        
								        
								           <td bgcolor="">
								            <p align="center">
							            	<span style="font-size:12pt;">
							            	
							             		<b>${trading.volume}</b>
		        						     </span>
								             </p>
								        </td>
								        
								        
								           <td bgcolor="">
								            <p align="center">
							            	<span style="font-size:12pt;">
							            		
							             		<b>${trading.trading_price}</b>
		        						     </span>
								             </p>
								        </td>
								        
								        
								        
								           <td bgcolor="">
								            <p align="center">
							            	<span style="font-size:12pt;">
							            		
							             		<b>${trading.status}</b>
		        						     </span>
								             </p>
								        </td>
								        
								        
									    </tr>
									   </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/login">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
	
    <!-- Page level plugins -->
    <script src="/resources/vendor/chart.js/Chart.min.js"></script>
    
    
    <!-- 그래프1 -->
   
    
	 
	 <script type="text/javascript">
	 Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	 Chart.defaults.global.defaultFontColor = '#858796';


	 var ctx = document.getElementById("myPieChart");
	 var myPieChart = new Chart(ctx, {
	   type: 'doughnut',
	   data: {
	     labels: ["자산총계", "부채총계"],
	     datasets: [{
	       data: [${stocks.asset}, ${stocks.debt}],
	       backgroundColor: ['#4e73df', '#1cc88a'],
	       hoverBackgroundColor: ['#2e59d9', '#17a673'],
	       hoverBorderColor: "rgba(234, 236, 244, 1)",
	     }],
	   },
	   options: {
	     maintainAspectRatio: false,
	     tooltips: {
	       backgroundColor: "rgb(255,255,255)",
	       bodyFontColor: "#858796",
	       borderColor: '#dddfeb',
	       borderWidth: 1,
	       xPadding: 15,
	       yPadding: 15,
	       displayColors: false,
	       caretPadding: 10,
	     },
	     legend: {
	       display: false
	     },
	     cutoutPercentage: 80,
	   },
	 });
</script>

		<!-- 그래프2 -->
	 <script type="text/javascript">
	 Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
	 Chart.defaults.global.defaultFontColor = '#858796';
	

	 var ctx = document.getElementById("myPieChart2");
	 var myPieChart = new Chart(ctx, {
	   type: 'doughnut',
	   data: {
	     labels: ["전체거래량","${stocks.company_name}거래량"],
	     datasets: [{
	       data: [${totalvolume},${volume}],
	       backgroundColor: ['#4e73df', '#1cc88a'],
	       hoverBackgroundColor: ['#2e59d9', '#17a673'],
	       hoverBorderColor: "rgba(234, 236, 244, 1)",
	     }],
	   },
	   options: {
	     maintainAspectRatio: false,
	     tooltips: {
	       backgroundColor: "rgb(255,255,255)",
	       bodyFontColor: "#858796",
	       borderColor: '#dddfeb',
	       borderWidth: 1,
	       xPadding: 15,
	       yPadding: 15,
	       displayColors: false,
	       caretPadding: 10,
	     },
	     legend: {
	       display: false
	     },
	     cutoutPercentage: 80,
	   },
	 });
</script>


<script type="text/javascript">
		
		function buy(stocks_code, price){
	  	  let buy = document.createElement('form'); 
		  let volume = document.getElementById("volume1");
		  
		  let code = document.createElement('input');
		  code.setAttribute('type', 'hidden');
		  code.setAttribute('name', 'stocks_code');
		  code.setAttribute('value', stocks_code);
		  
		  let pri = document.createElement('input');
		  pri.setAttribute('type', 'hidden');
		  pri.setAttribute('name', 'price');
		  pri.setAttribute('value', price);
		  
		  buy.appendChild(volume);
		  buy.appendChild(code);
		  buy.appendChild(pri);
		  
		  buy.setAttribute('method', 'POST');
		  buy.setAttribute('action', '/buy'); 
		  document.body.appendChild(buy);
		  buy.submit();
		}
		
		function sell(stocks_code, price){
		  	  let sell = document.createElement('form'); 
			  let volume = document.getElementById("volume2");
			  
			  let code = document.createElement('input');
			  code.setAttribute('type', 'hidden');
			  code.setAttribute('name', 'stocks_code');
			  code.setAttribute('value', stocks_code);
			  
			  let pri = document.createElement('input');
			  pri.setAttribute('type', 'hidden');
			  pri.setAttribute('name', 'price');
			  pri.setAttribute('value', price);
			  
			  sell.appendChild(volume);
			  sell.appendChild(code);
			  sell.appendChild(pri);
			  
			  sell.setAttribute('method', 'POST');
			  sell.setAttribute('action', '/sell'); 
			  document.body.appendChild(sell);
			  sell.submit();
		}
		
</script>



	 <!-- 랜덤 -->
   <script>
        let generateNum = document.querySelector(".countNumber");
        let button = document.querySelector(".generate");

        function generator(){
            const randomNum = ((Math.round(Math.random() * 100 - 50)/100) + (Math.round(Math.random() * 100 - 50)/100)).toFixed(2);
            //Math.random 0~1 사이의 난수 생성
            //Math.floor 소수점을 내림시켜 정수로 만듦
            generateNum.innerHTML = randomNum + '%';

        }
        button.addEventListener("click", generator);

    </script>
	










</body>

</html>