import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import EntryList from './EntryList';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<EntryList />, document.getElementById('root'));
registerServiceWorker();
