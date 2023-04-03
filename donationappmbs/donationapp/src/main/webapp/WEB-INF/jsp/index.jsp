<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Dashboard - Good Hands</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Refresh (page) -->
<meta http-equiv="refresh" content="10">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

</head>

<body>

	<!-- End Header -->

	<!-- End Sidebar-->

	<main id="main" class="main">
	
	<c:import url="/WEB-INF/jsp/menu.jsp" />


		<!-- End Page Title -->

		<section class="section dashboard">
			<div class="row">

				<!-- Left side columns -->
				<div class="col-lg-8">
					<div class="row">

						<!-- Sales Card -->
						<!-- End Sales Card -->

						<!-- Revenue Card -->
						<div class="col-xxl-4 col-md-6">
							<div class="card info-card revenue-card">

								<div class="card-body">
									<h5 class="card-title">
										Novas doações <span>| Esse mês</span>
									</h5>

									<div class="d-flex align-items-center">
										<div
											class="card-icon rounded-circle d-flex align-items-center justify-content-center">
											<i class="bi bi-currency-dollar"></i>
										</div>
										<div class="ps-3">
											<h6>R$300.264,00</h6>
											<span class="text-success small pt-1 fw-bold">8%</span> <span
												class="text-muted small pt-2 ps-1">aumento</span>

										</div>
									</div>
								</div>

							</div>
						</div>
						<!-- End Revenue Card -->

					</div>
					<!-- End Customers Card -->

					<!-- Reports -->
					<div class="col-12">
						<div class="card">

							<div class="card-body">
								<h5 class="card-title">
									Reports <span>/Hoje</span>
								</h5>

								<!-- Line Chart -->
								<div id="reportsChart"></div>

								<script>
                    document.addEventListener("DOMContentLoaded", () => {
                      new ApexCharts(document.querySelector("#reportsChart"), {
                        series: [{
                          name: 'Transações',
                          data: [31, 40, 28, 51, 42, 82, 56],
                        }, {
                          name: 'Produtos doados',
                          data: [11, 32, 45, 32, 34, 52, 41]
                        }, {
                          name: 'Doadores',
                          data: [15, 11, 32, 18, 9, 24, 11]
                        }],
                        chart: {
                          height: 350,
                          type: 'area',
                          toolbar: {
                            show: false
                          },
                        },
                        markers: {
                          size: 4
                        },
                        colors: ['#4154f1', '#2eca6a', '#ff771d'],
                        fill: {
                          type: "gradient",
                          gradient: {
                            shadeIntensity: 1,
                            opacityFrom: 0.3,
                            opacityTo: 0.4,
                            stops: [0, 90, 100]
                          }
                        },
                        dataLabels: {
                          enabled: false
                        },
                        stroke: {
                          curve: 'smooth',
                          width: 2
                        },
                        xaxis: {
                          type: 'datetime',
                          categories: ["2018-09-19T00:00:00.000Z", "2018-09-19T01:30:00.000Z", "2018-09-19T02:30:00.000Z", "2018-09-19T03:30:00.000Z", "2018-09-19T04:30:00.000Z", "2018-09-19T05:30:00.000Z", "2018-09-19T06:30:00.000Z"]
                        },
                        tooltip: {
                          x: {
                            format: 'dd/MM/yy HH:mm'
                          },
                        }
                      }).render();
                    });
                  </script>
								<!-- End Line Chart -->

							</div>

						</div>
					</div>
					<!-- End Reports -->

					<!-- Recent Sales -->
					<div class="col-12">
						<div class="card recent-sales overflow-auto">

							<div class="card-body">
								<h5 class="card-title">
									Doações recentes <span>| Hoje</span>
								</h5>

								<table class="table table-borderless datatable">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">Doador</th>
											<th scope="col">Produto</th>
											<th scope="col">Status</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row"><a href="#">#2457</a></th>
											<td>Elvis Presley</td>
											<td><a href="#" class="text-primary">At praesentium
													minu</a></td>
											<td><span class="badge bg-success">Aprovada</span></td>
										</tr>
										<tr>
											<th scope="row"><a href="#">#2147</a></th>
											<td>Kurt Cobain</td>
											<td><a href="#" class="text-primary">Blanditiis
													dolor omnis similique</a></td>
											<td><span class="badge bg-warning">Pendente</span></td>
										</tr>
										<tr>
											<th scope="row"><a href="#">#2049</a></th>
											<td>Janis Joplin</td>
											<td><a href="#" class="text-primary">At recusandae
													consectetur</a></td>
											<td><span class="badge bg-success">Aprovada</span></td>
										</tr>
										<tr>
											<th scope="row"><a href="#">#2644</a></th>
											<td>Chris Cornell</td>
											<td><a href="#" class="text-primar">Ut voluptatem id
													earum et</a></td>
											<td><span class="badge bg-danger">Rejeitada</span></td>
										</tr>
										<tr>
											<th scope="row"><a href="#">#2644</a></th>
											<td>Joey Ramone</td>
											<td><a href="#" class="text-primary">Sunt similique
													distinctio</a></td>
											<td><span class="badge bg-success">Aprovada</span></td>
										</tr>
									</tbody>
								</table>

							</div>

						</div>
					</div>
					<!-- End Recent Sales -->

					<!-- Top Selling -->
					<div class="col-12">
						<div class="card top-selling overflow-auto">

							<div class="filter">
								<a class="icon" href="#" data-bs-toggle="dropdown"><i
									class="bi bi-three-dots"></i></a>
							</div>

							<div class="card-body pb-0">
								<h5 class="card-title">
									Doações <span>| Hoje</span>
								</h5>

								<table class="table table-borderless">
									<thead>
										<tr>
											<th scope="col"></th>
											<th scope="col">Produto</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row"><a href="#"><img
													src="assets/img/product-1.jpg" alt=""></a></th>
											<td><a href="#" class="text-primary fw-bold">Ut
													inventore ipsa voluptas nulla</a></td>
										</tr>
										<tr>
											<th scope="row"><a href="#"><img
													src="assets/img/product-2.jpg" alt=""></a></th>
											<td><a href="#" class="text-primary fw-bold">Exercitationem
													similique doloremque</a></td>
										</tr>
										<tr>
											<th scope="row"><a href="#"><img
													src="assets/img/product-3.jpg" alt=""></a></th>
											<td><a href="#" class="text-primary fw-bold">Doloribus
													nisi exercitationem</a></td>
										</tr>
										<tr>
											<th scope="row"><a href="#"><img
													src="assets/img/product-4.jpg" alt=""></a></th>
											<td><a href="#" class="text-primary fw-bold">Officiis
													quaerat sint rerum error</a></td>
										</tr>
										<tr>
											<th scope="row"><a href="#"><img
													src="assets/img/product-5.jpg" alt=""></a></th>
											<td><a href="#" class="text-primary fw-bold">Sit
													unde debitis delectus repellendus</a></td>
										</tr>
									</tbody>
								</table>

							</div>

						</div>
					</div>
					<!-- End Top Selling -->

				</div>
			</div>
			<!-- End Left side columns -->

			<!-- Right side columns -->
			<div class="col-lg-4">

				<!-- Recent Activity -->
				<div class="card">
					<div class="filter">
						<a class="icon" href="#" data-bs-toggle="dropdown"><i
							class="bi bi-three-dots"></i></a>
						<ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
							<li class="dropdown-header text-start"></li>
						</ul>
					</div>

					<div class="card-body">
						<h5 class="card-title">
							Atividade recente <span>| Hoje</span>
						</h5>

						<div class="activity">

							<div class="activity-item d-flex">
								<div class="activite-label">32 min</div>
								<i
									class='bi bi-circle-fill activity-badge text-success align-self-start'></i>
								<div class="activity-content">
									Quia quae rerum <a href="#" class="fw-bold text-dark">explicabo
										officiis</a> beatae
								</div>
							</div>
							<!-- End activity item-->

							<div class="activity-item d-flex">
								<div class="activite-label">56 min</div>
								<i
									class='bi bi-circle-fill activity-badge text-danger align-self-start'></i>
								<div class="activity-content">Voluptatem blanditiis
									blanditiis eveniet</div>
							</div>
							<!-- End activity item-->

							<div class="activity-item d-flex">
								<div class="activite-label">2 hrs</div>
								<i
									class='bi bi-circle-fill activity-badge text-primary align-self-start'></i>
								<div class="activity-content">Voluptates corrupti
									molestias voluptatem</div>
							</div>
							<!-- End activity item-->

							<div class="activity-item d-flex">
								<div class="activite-label">1 day</div>
								<i
									class='bi bi-circle-fill activity-badge text-info align-self-start'></i>
								<div class="activity-content">
									Tempore autem saepe <a href="#" class="fw-bold text-dark">occaecati
										voluptatem</a> tempore
								</div>
							</div>
							<!-- End activity item-->

							<div class="activity-item d-flex">
								<div class="activite-label">2 days</div>
								<i
									class='bi bi-circle-fill activity-badge text-warning align-self-start'></i>
								<div class="activity-content">Est sit eum reiciendis
									exercitationem</div>
							</div>
							<!-- End activity item-->

							<div class="activity-item d-flex">
								<div class="activite-label">4 weeks</div>
								<i
									class='bi bi-circle-fill activity-badge text-muted align-self-start'></i>
								<div class="activity-content">Dicta dolorem harum nulla
									eius. Ut quidem quidem sit quas</div>
							</div>
							<!-- End activity item-->

						</div>

					</div>
				</div>
				<!-- End Recent Activity -->

				<!-- Website Traffic -->
				<div class="card">
					<div class="filter">
						<a class="icon" href="#" data-bs-toggle="dropdown"><i
							class="bi bi-three-dots"></i></a>

						<div class="card-body pb-0">
							<h5 class="card-title">
								Acessos no site <span>| Hoje</span>
							</h5>

							<div id="trafficChart" style="min-height: 400px;" class="echart"></div>

							<script>
                document.addEventListener("DOMContentLoaded", () => {
                  echarts.init(document.querySelector("#trafficChart")).setOption({
                    tooltip: {
                      trigger: 'item'
                    },
                    legend: {
                      top: '5%',
                      left: 'center'
                    },
                    series: [{
                      name: 'Access From',
                      type: 'pie',
                      radius: ['40%', '70%'],
                      avoidLabelOverlap: false,
                      label: {
                        show: false,
                        position: 'center'
                      },
                      emphasis: {
                        label: {
                          show: true,
                          fontSize: '18',
                          fontWeight: 'bold'
                        }
                      },
                      labelLine: {
                        show: false
                      },
                      data: [{
                          value: 1048,
                          name: 'Search Engine'
                        },
                        {
                          value: 735,
                          name: 'Direct'
                        },
                        {
                          value: 580,
                          name: 'Email'
                        },
                        {
                          value: 484,
                          name: 'Union Ads'
                        },
                        {
                          value: 300,
                          name: 'Video Ads'
                        }
                      ]
                    }]
                  });
                });
              </script>

						</div>
					</div>
					<!-- End Website Traffic -->

					<!-- News & Updates Traffic -->
					<div class="card">
						<div class="filter">
							<a class="icon" href="#" data-bs-toggle="dropdown"><i
								class="bi bi-three-dots"></i></a>
						</div>

						<div class="card-body pb-0">
							<h5 class="card-title">
								Notícias &amp; Atualizações <span>| Hoje</span>
							</h5>

							<div class="news">
								<div class="post-item clearfix">
									<img src="assets/img/news-1.jpg" alt="">
									<h4>
										<a href="#">Nihil blanditiis at in nihil autem</a>
									</h4>
									<p>Sit recusandae non aspernatur laboriosam. Quia enim
										eligendi sed ut harum...</p>
								</div>

								<div class="post-item clearfix">
									<img src="assets/img/news-2.jpg" alt="">
									<h4>
										<a href="#">Quidem autem et impedit</a>
									</h4>
									<p>Illo nemo neque maiores vitae officiis cum eum turos
										elan dries werona nande...</p>
								</div>

								<div class="post-item clearfix">
									<img src="assets/img/news-3.jpg" alt="">
									<h4>
										<a href="#">Id quia et et ut maxime similique occaecati ut</a>
									</h4>
									<p>Fugiat voluptas vero eaque accusantium eos. Consequuntur
										sed ipsam et totam...</p>
								</div>

								<div class="post-item clearfix">
									<img src="assets/img/news-4.jpg" alt="">
									<h4>
										<a href="#">Laborum corporis quo dara net para</a>
									</h4>
									<p>Qui enim quia optio. Eligendi aut asperiores enim
										repellendusvel rerum cuder...</p>
								</div>

								<div class="post-item clearfix">
									<img src="assets/img/news-5.jpg" alt="">
									<h4>
										<a href="#">Et dolores corrupti quae illo quod dolor</a>
									</h4>
									<p>Odit ut eveniet modi reiciendis. Atque cupiditate libero
										beatae dignissimos eius...</p>
								</div>

							</div>
							<!-- End sidebar recent posts-->

						</div>
					</div>
					<!-- End News & Updates -->

				</div>
				<!-- End Right side columns -->

			</div>
		</section>

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer" class="footer">
		<div class="copyright">
			&copy; Copyright <strong><span>Mariana Buhrer
					Sukevicz - Infnet - 2023</span></strong>. Direitos reservados
		</div>
		<div class="credits">
			<!-- All the links in the footer should remain intact. -->
			<!-- You can delete the links only if you purchased the pro version. -->
			<!-- Licensing information: https://bootstrapmade.com/license/ -->
			<!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
		</div>
	</footer>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/chart.js/chart.umd.js"></script>
	<script src="assets/vendor/echarts/echarts.min.js"></script>
	<script src="assets/vendor/quill/quill.min.js"></script>
	<script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="assets/vendor/tinymce/tinymce.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>