<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="Website.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="style/login.css" rel="stylesheet" />
</head>
<body>
    <form id="form1" runat="server">
        <div class ="loginbox ">
            <table style="width: 100%;">
                <tr>
                    <td>用户名：</td>
                    <td><asp:TextBox ID="TextBoxusername" runat="server" required></asp:TextBox></td>
                    
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><asp:TextBox ID="TextBoxpassword" runat="server" TextMode="Password" required></asp:TextBox></td>
                    
                </tr>
            </table>
            <div class ="buttondiv ">
                <asp:Button ID="ButtonLogin" runat="server" Text="登录" OnClick="ButtonLogin_Click" />
                <br />
                <asp:Label ID="LabelAlert" runat="server" Text="" ForeColor="Red"></asp:Label>
            </div>
        </div>
    </form>
</body>
</html>
