using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Website.admin
{
    public partial class user_list : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GridViewList_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "del")
            {
                int del_id = Tool.Tool.Obj2Int(e.CommandArgument.ToString());
                using (var ctx = new Models.ynnuEntities())
                {
                    var user = ctx.user.Where(s => s.id == del_id).FirstOrDefault();
                    if (user != null)
                    {
                        ctx.user.Remove(user);

                        ctx.SaveChanges();

                        GridViewList.DataBind();
                    }
                }
            }
        }
    }
}