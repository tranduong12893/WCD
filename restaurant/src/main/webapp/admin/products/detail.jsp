<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.restaurant.entity.Product" %>
<%@ page import="com.example.restaurant.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.restaurant.entity.myenum.ProductStatus" %><%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 5/12/22
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product obj = (Product) request.getAttribute("obj");
    Category category = (Category) request.getAttribute("category");
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
                        <h1>Product management</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="/admin/products/list">Product Management</a></li>
                            <li class="breadcrumb-item active">Create new</li>
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

                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="card card-warning">
                            <div class="card-header">
                                <h3 class="card-title">Please enter information below</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <form name="product-form">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <!-- text input-->
                                            <div class="form-group">
                                                <label>Name</label>
                                                <input type="text" name="name" value="<%=obj.getName()%>" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <!-- select -->
                                            <div class="form-group">
                                                <label>Category</label>
                                                <input type="text" name="CategoryId" value="<%=category.getName()%>" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Price</label>
                                                <input type="text" name="price" value="<%=obj.getPrice()%>" class="form-control" placeholder="Please enter price">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <!-- text input -->
                                            <div class="form-group">
                                                <label>Description</label>
                                                <input type="text" name="description" value="<%=obj.getDescription()%>" class="form-control" placeholder="Please enter description">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <div class="form-group">
                                                <label>Thumbnail</label>
                                                <img id="preview-image" src="<%=obj.getThumbnail()%>" alt="" class="img-bordered mt-2" width="200px">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.card-body -->
                        </div>
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
<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
<script>
    document.addEventListener('DOMContentLoaded', function (){
        $('#summernote').summernote();
        var myWidget = cloudinary.createUploadWidget({
                cloudName: 'anhson',
                uploadPreset: 'mku1eljf'}, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info.secure_url);
                    document.forms['product-form']['thumbnail'].value = result.info.secure_url;
                    document.getElementById('preview-image').src = result.info.secure_url;
                    document.getElementById('preview-image').style.display = "block";
                }
            }
        )

        document.getElementById("upload_widget").addEventListener("click", function(){
            myWidget.open();
        }, false);
    })
</script>
</body>
</html>