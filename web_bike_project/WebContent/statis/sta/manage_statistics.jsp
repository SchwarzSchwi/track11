<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Common_header.jsp"%>
				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
							</header>
							<section class="">
								<div class="main_title" style="text-align:center;">
									<h1>판매 통계</h1>
								</div>
							</section>
							<section class="lines">
								<form name="admin">
									<table class="boardForm">
										<colgroup>
											<col width="100">
											<col width="100">
											<col width="152">
											<col width="352">
										</colgroup>
										<tr class="statics_text">
											<th colspan="2">총 판매 건 수</th>
											<td colspan="2">
												<input type="text" name="" value="" disabled style="border:none;">
											</td>
										</tr>
										<tr class="statics_text">
											<th colspan="2">총 매출액</th>
											<td colspan="2">
												<input type="text" name="" value="" disabled style="border:none;">
											</td>
										</tr>
										<tr>
											<th colspan="3" style="padding-top:0.75em;">
												제품별 판매 건수
											</th>
											<th style="padding-top:0.75em;">
												고객별 매출액 
											</th>
										</tr>
										<tr>
											<td colspan="3">
												<div style="width: 352px; height: 176px;">
													<canvas id="p_Count"></canvas>
												</div>
											</td>
											<td>
												<div style="width: 352px; height: 176px;">
													<canvas id="c_Cell"></canvas>
												</div>
											</td>
										</tr>
										<tr>
											<th colspan="2">월별 통계</th>
											<td colspan="2"><input type="month" name="t_month" onchange=""></td>
										</tr>
									</table>
									<div id="hide" style="display:none;">
									<table class="boardForm">
										<colgroup>
											<col width="100">
											<col width="100">
											<col width="152">
											<col width="352">
										</colgroup>
										
											<tr class="statics_text ">
												<th colspan="2">월별 판매 건 수</th>
												<td colspan="2">
													<input type="text" name="t_count_m" disabled style="border:none;">
												</td>
											</tr>
											<tr class="statics_text ">
												<th colspan="2">월별 매출액</th>
												<td colspan="2">
													<input type="text" name="t_sell_m" disabled style="border:none;">
												</td>
											</tr>
											<tr >
												<th colspan="3">
													제품별 월 판매 건수
												</th>
												<th>
													고객별 월 매출액 
												</th>
											</tr>
											<tr >
												<td colspan="3">
													<div style="width: 352px; height: 176px;">
													<canvas id="p_Count_m"></canvas>
												</div>
												</td>
												<td>
													<div style="width: 352px; height: 176px;">
													<canvas id="c_Cell_m"></canvas>
												</div>
												</td>
											</tr>
										</table>
									</div>
								</form>
							</section>
						</div>
					</div>
<%@ include file="../Common_footer.jsp"%>