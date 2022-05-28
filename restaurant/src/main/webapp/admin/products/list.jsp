<%@ page import="com.example.restaurant.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.restaurant.entity.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> list = (List<Product>)request.getAttribute("list");
    if(list == null){
        list = new ArrayList<>();
    }

%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../includes/head.jsp"></jsp:include>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title"><%= (String) request.getAttribute("title")%></h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card card-solid">
                                <div class="card-body pb-0">
                                    <div class="row">
                                        <%for (Product obj : list) {
                                        %>
                                        <div class="col-12 col-sm-6 col-md-4 d-flex align-items-stretch flex-column">
                                            <div class="card bg-light d-flex flex-fill">
                                                <div class="card-header text-muted border-bottom-0">

                                                </div>
                                                <div class="card-body pt-0">
                                                    <div class="row">
                                                        <div class="col-7">
                                                            <h2 class="lead"><b><%=obj.getName()%></b></h2>
                                                            <p class="text-muted text-lg"><b>Price: </b><%=obj.getPrice()%> </p>
                                                            <p class="ml-4 mb-0 fa-ul text-muted"><%=obj.getDescription()%></p>
                                                        </div>
                                                        <div class="col-5 text-center">
                                                            <img src="<%=obj.getThumbnail()%>" class=" img-fluid">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card-footer">
                                                    <div class="text-right">
                                                        <a href="/products/detail?id=<%=obj.getId()%>" class="btn btn-sm btn-primary">
                                                            <i class="fas fa-solid fa-eye"></i> Detail
                                                        </a>
                                                        <a href="/products/edit?id=<%=obj.getId()%>" class="btn btn-sm btn-primary">
                                                            <i class="fas fa-edit"></i> Edit
                                                        </a>
                                                        <a href="/products/delete?id=<%=obj.getId()%>" class="btn btn-sm btn-primary" onclick="return confirm('Are you sure?')">
                                                            <i class="fas fa-solid fa-trash"></i> Delete
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <%}%>
                                    </div>
                                </div>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="../includes/footer.jsp"></jsp:include>
    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>
<script></script>
</body>
</html>
