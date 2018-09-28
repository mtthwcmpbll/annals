import React, {Component} from 'react';
import './EntryList.css';
import Entry from './Entry';

class EntryList extends Component {
    state = {
        isLoading: true,
        entries: []
    };

    async componentDidMount() {
        const response = await fetch('/api/entries');
        const body = await response.json();
        this.setState({entries: body, isLoading: false});
    }

    render() {
        const {entries, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="EntryList">
                {entries.map(entry=>
                    <Entry entry={entry} key={entry.id}/>
                )}
            </div>
        );
    }
}

export default EntryList;
