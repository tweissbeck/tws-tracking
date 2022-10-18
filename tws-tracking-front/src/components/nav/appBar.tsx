import React from 'react';
import {MenuItem, Toolbar, Typography} from "@mui/material";
import AppBar from '@mui/material/AppBar';

import {useLocation, useNavigate} from "react-router-dom";
import TrackChangesIcon from '@mui/icons-material/TrackChanges';

/**
 * Application page
 */
export type Page = {
    /**
     * Key prop
     */
    key: string,
    /**
     * Displayed label on menu item
     */
    label: string,
    /**
     * Url used by react router (useNavigate().navigate(navTo))
     */
    navTo: string
}

/**
 * Application bar props
 */
interface TAppBarProps {
    pages: Page[]
}

/**
 * App bar component
 * @param props
 * @constructor
 */
function TAppBar(props: TAppBarProps) {
    const {pages} = props
    const navigate = useNavigate();
    const location = useLocation();
    const handleMenuClick = function (page: Page) {
        navigate(page.navTo)
    }

    return (
        <AppBar position="static" color={"secondary"}>
            <Toolbar>
                <TrackChangesIcon></TrackChangesIcon>
                <Typography variant="h6" component="div">
                    TWS Tracker
                </Typography>

                {pages.map(page =>
                    <MenuItem
                        key={page.key} onClick={() => handleMenuClick(page)}
                        selected={location.pathname === page.navTo}
                    >
                        <Typography textAlign="center">{page.label}</Typography>
                    </MenuItem>
                )}

            </Toolbar>
        </AppBar>
    )
}

export default TAppBar