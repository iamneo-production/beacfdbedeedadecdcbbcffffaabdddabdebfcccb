import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import Hidden from "@mui/material/Hidden";
import Drawer from "@mui/material/Drawer";
import List from "@mui/material/List";
import ListItem from "@mui/material/ListItem";
import ListItemText from "@mui/material/ListItemText";
import { Link } from "react-router-dom";

export default function Navbar() {
  const [isDrawerOpen, setIsDrawerOpen] = React.useState(false);

  const toggleDrawer = () => {
    setIsDrawerOpen(!isDrawerOpen);
  };
  const handleListItemClick = () => {
    setIsDrawerOpen(false); // Close the drawer when a list item is clicked
  };

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" style={{ background: "#000000" }}>
        <Toolbar sx={{ justifyContent: "space-between" }}>
          <div>
            <Hidden smUp>
              <IconButton
                size="large"
                edge="start"
                color="inherit"
                aria-label="menu"
                sx={{ mr: 2 }}
                onClick={toggleDrawer}
              >
                <MenuIcon />
              </IconButton>
            </Hidden>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              VacServ
            </Typography>
          </div>
          <Hidden smDown>
            <div>
              {/* Conditionally render buttons based on drawer state */}
              {!isDrawerOpen && (
                <>
                  <Link to="/user/homepage" className="nav-link" style={{ color: "white" }}>
                    <Button color="inherit" id="homeButton">
                      Home
                    </Button>
                  </Link>
                  <Link to="/user/dashboardGrid" className="nav-link">
                    <Button color="inherit" id="dashboardButton" style={{ color: "white" }}>
                      Dashboard
                    </Button>
                  </Link>
                  <Link to="/user/appointment" className="nav-link">
                  <Button color="inherit" id="myBookingButton" style={{ color: "white" }}>
                    My Bookings
                  </Button>
                  </Link>
                </>
              )}
            </div>
          </Hidden>
          <div>
            <Link to="/" className="nav-link">
              <Button style={{ color: "red" }}>Logout</Button>
            </Link>
          </div>
        </Toolbar>
      </AppBar>
      <Drawer
        anchor="left"
        open={isDrawerOpen}
        onClose={toggleDrawer}
        variant="temporary"
      >
        <List>
          <ListItem button onClick={handleListItemClick}>
            <ListItemText primary="Home" />
          </ListItem>
          <ListItem button onClick={handleListItemClick}>
            <ListItemText primary="Dashboard" />
          </ListItem>
          <ListItem button onClick={handleListItemClick}>
            <ListItemText primary="My Bookings" />
          </ListItem>
        </List>
      </Drawer>
    </Box>
  );
}
