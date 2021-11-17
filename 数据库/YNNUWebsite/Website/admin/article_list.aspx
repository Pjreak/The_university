<%@ Page Title="文章列表" Language="C#" MasterPageFile="~/admin/admin.Master" AutoEventWireup="true" CodeBehind="article_list.aspx.cs" Inherits="Website.admin.article_list" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <asp:GridView ID="GridViewList" runat="server" Width="100%" AutoGenerateColumns="False" CellPadding="4" DataKeyNames="id" DataSourceID="SqlDataSourceList" ForeColor="#333333" GridLines="None" OnRowCommand="GridViewList_RowCommand">
        <AlternatingRowStyle BackColor="White" />
        <Columns>
            <asp:TemplateField HeaderText="操作">
                <ItemTemplate>
                    <asp:HyperLink ID="HyperLinkEdit" runat="server" NavigateUrl='<%# Eval("id", "article_edit.aspx?id={0}") %>'>编辑</asp:HyperLink>
                    <asp:LinkButton ID="LinkButtonDel" runat="server" CommandArgument='<%# Eval("id") %>' CommandName="del">删除</asp:LinkButton>
                </ItemTemplate>
                <HeaderStyle Width="15%" />
            </asp:TemplateField>
            <asp:BoundField DataField="id" HeaderText="标识" ReadOnly="True" SortExpression="id">
            <HeaderStyle Width="10%" />
            </asp:BoundField>
            <asp:BoundField DataField="title" HeaderText="标题" SortExpression="title" />
            <asp:BoundField DataField="menu_id" HeaderText="menu_id" SortExpression="menu_id" Visible="False" />
            <asp:BoundField DataField="writer" HeaderText="作者" SortExpression="writer">
            <HeaderStyle Width="10%" />
            </asp:BoundField>
            <asp:BoundField DataField="add_time" HeaderText="添加时间" SortExpression="add_time">
            <HeaderStyle Width="10%" />
            </asp:BoundField>
            <asp:BoundField DataField="click" HeaderText="点击数" SortExpression="click">
            <HeaderStyle Width="5%" />
            </asp:BoundField>
        </Columns>
        <EditRowStyle BackColor="#2461BF" />
        <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
        <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
        <RowStyle BackColor="#EFF3FB" />
        <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
        <SortedAscendingCellStyle BackColor="#F5F7FB" />
        <SortedAscendingHeaderStyle BackColor="#6D95E1" />
        <SortedDescendingCellStyle BackColor="#E9EBEF" />
        <SortedDescendingHeaderStyle BackColor="#4870BE" />
    </asp:GridView>
    <asp:SqlDataSource ID="SqlDataSourceList" runat="server" ConnectionString="<%$ ConnectionStrings:ynnuConnectionString %>" SelectCommand="SELECT [id], [title], [menu_id], [writer], [click], [add_time] FROM [article] ORDER BY [add_time] DESC"></asp:SqlDataSource>
</asp:Content>
