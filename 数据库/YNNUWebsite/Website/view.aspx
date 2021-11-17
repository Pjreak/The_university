<%@ Page Title="" Language="C#" MasterPageFile="~/web.Master" AutoEventWireup="true" CodeBehind="view.aspx.cs" Inherits="Website.view" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="view">
        <asp:Repeater ID="RepeaterArticle" runat="server" DataSourceID="SqlDataSourceArticle" >
                    <ItemTemplate>
                      <div class="title"><%# Eval("title") %></div>
                        <div class="info"><%# Eval("add_time","{0:yyyy-MM-dd}") %> &nbsp;&nbsp;&nbsp;<%# Eval("click","点击:[{0}]") %></div>
                        <hr />
                        <div class="text">
                            <%# Eval("text") %>
                        </div>
                    </ItemTemplate>
                </asp:Repeater>
        <asp:SqlDataSource ID="SqlDataSourceArticle" runat="server" ConnectionString="<%$ ConnectionStrings:ynnuConnectionString %>" SelectCommand="SELECT DISTINCT * FROM [article] WHERE ([id] = @id)">
            <SelectParameters>
                <asp:QueryStringParameter Name="id" QueryStringField="id" Type="Int32" />
            </SelectParameters>
        </asp:SqlDataSource>
    </div>
</asp:Content>
