import React, {Component} from 'react';
import { Menu, Container, Dropdown } from 'semantic-ui-react'

class NavBar extends Component {
    state = { activeItem: 'entries' }

    handleItemClick = (e, { name }) => this.setState({ activeItem: name })

    render() {
        const { activeItem } = this.state

        return (
            <Menu fixed='top' borderless>
                <Container>
                    <Menu.Item header>Annals</Menu.Item>
                    <Menu.Item
                        name='entries'
                        active={activeItem === 'entries'}
                        onClick={this.handleItemClick} />

                    <Menu.Menu position='right'>
                        <Dropdown item simple text='Account' direction='right'>
                            <Dropdown.Menu>
                                <Dropdown.Item>Settings</Dropdown.Item>
                                <Dropdown.Divider />
                                <Dropdown.Item>Log Out</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </Menu.Menu>
                </Container>
            </Menu>
        );
    }
}

export default NavBar;
